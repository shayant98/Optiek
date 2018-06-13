<%-- 
    Document   : producten
    Created on : Nov 15, 2017, 10:31:45 PM
    Author     : shayantsital
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
        <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producten Overzicht</title>
    </head>
    <body>

        <div class="col-md-12">
            <ul class="nav nav-tabs navbar-primary">
        <li role="presentation"><a href="index.html">Home</a></li>
        <li role="presentation"><a href="Klanten">Klanten</a></li>
        <li role="presentation" class="active"><a href="Producten">Producten</a></li>
        <li role="presentation"><a href="History">Verkoop</a></li>
        <li role="presentation"><a href="Tests">Oogmetingen</a></li>
        </ul>
                        <h1>Producten Overzicht</h1>

            <div class="container">
                
                <div class="row">
         <p style="color: red;">${errorString}</p>
        <table  class="table" id="example">
            
            <thead>
       <tr>
          <th>#</th>
          <th>Naam</th>
          <th>Type</th>
          <th>Merk</th>
          <th>Aantal</th>
       </tr>
       </thead>
        <tbody>
       <c:forEach items="${producten}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><c:out value="${product.naam}" /></td>
            <td><c:out value="${product.type}" /></td>
            <td><c:out value="${product.brand}" /></td>
             <td><c:out value="${product.quantity}" /></td>

        </tr>
         
    </c:forEach>
        </tbody>
        

    </table>
        </div>
        <input type="submit" value="Product Toevoegen" class="btn  btn-info" data-toggle="modal" data-target="#productModal"/>
          <div id="productModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Product </h4>
      </div>
      <div class="modal-body">
        <form method="POST" action="${pageContext.request.contextPath}/InsertProduct">
            <div class="form-group">
                
            </div>
           
            <div class="form-group">
                <label>Type</label>
<!--                <input type="text" name="Type" class="form-control" value="${product.type}" />-->
                <select name="Type" class="selectpicker form-control">
                    <option value="Bril">Bril</option>
                    <option value="Glazen">Glazen</option>
                    <option value="Kinderbril">Kinderbril</option>
                    <option value="Lenzen">Lenzen</option>
                    <option value="Zonnebril">Zonnebril</option>
                </select>
                
            </div>
            <div class="form-group">
                <label>Merk</label>
                <input type="text" name="Brand" class="form-control" value="${product.brand}" />
            </div>
            <div class="form-group">
                <label>Aantal</label>
                <input type="text" name="Quantity" class="form-control" value="${product.quantity}" />
            </div>
            <div class="form-group">
                <label>Naam</label>
                <input type="text" name="Name" class="form-control" value="${product.Naam}" />
            </div>
            <div class="form-group">
                <input type="submit" value="Submit" class="btn  btn-success"/>
                   <a href="Producten" class="btn btn-warning pull-right">Cancel</a>
            </div>

      </form>
      </div>
    </div>

  </div>
        </div>
                </div>
       
    </body>
            <script src="//code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
            <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
           <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
           <script src="//cdn.datatables.net/plug-ins/1.10.16/i18n/Dutch.json"></script>
           <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
                      <script>
            $(document).ready(function() {
                $('#example').DataTable({
                    "language": {
                "sProcessing": "Bezig...",
                "sLengthMenu": "_MENU_ resultaten weergeven",
                "sZeroRecords": "Geen resultaten gevonden",
                "sInfo": "_START_ tot _END_ van _TOTAL_ resultaten",
                "sInfoEmpty": "Geen resultaten om weer te geven",
                "sInfoFiltered": " (gefilterd uit _MAX_ resultaten)",
                "sInfoPostFix": "",
                "sSearch": "Zoeken:",
                "sEmptyTable": "Geen resultaten aanwezig in de tabel",
                "sInfoThousands": ".",
                "sLoadingRecords": "Een moment geduld aub - bezig met laden...",
                "oPaginate": {
                    "sFirst": "Eerste",
                    "sLast": "Laatste",
                    "sNext": "Volgende",
                    "sPrevious": "Vorige"
                },
                "oAria": {
                    "sSortAscending":  ": activeer om kolom oplopend te sorteren",
                    "sSortDescending": ": activeer om kolom aflopend te sorteren"
                }
            }
                });
                 $('.selectpicker').selectpicker({
                    style: 'btn-default',
                    size: 4
                  });
            } );
</script>
</html>
