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
        <title>Geschiedenis Overzicht</title>
    </head>
    <body>
               

        <div class="col-md-12">
             <ul class="nav nav-tabs navbar-primary">
        <li role="presentation"><a href="index.html">Home</a></li>
        <li role="presentation"><a href="Klanten">Klanten</a></li>
        <li role="presentation"><a href="Producten">Producten</a></li>
        <li role="presentation" class="active"><a href="History">Verkoop</a></li>
        <li role="presentation"><a href="Tests">Oogmetingen</a></li>
        </ul>
                        <h1>Verkoop Overzicht</h1>

            <div class="container">
                
                <div class="row">
         <p style="color: red;">${errorString}</p>
        <table  class="table" id="example">
            
            <thead>
       <tr>
          <th>#</th>
          <th>Naam</th>
          <th>Familienaam</th>
          <th>Product #</th>
          <th>Product Naam</th>
          <th>Datum</th>
       </tr>
       </thead>
        <tbody>
       <c:forEach items="${History}" var="history">
        <tr>
            <td>${history.id}</td>
            <td><c:out value="${history.name}" /></td>
            <td><c:out value="${history.surname}" /></td> 
            <td><c:out value="${history.product_id}" /></td>
            <td><c:out value="${history.productName}" /></td>
            <td><c:out value="${history.date}" /></td>
           

        </tr>
         
    </c:forEach>
        </tbody>
        

    </table>
        </div>
        <input type="submit" value="Aankoop Toevoegen" class="btn  btn-info" data-toggle="modal" data-target="#purchaseModal"/>
        <div id="purchaseModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Aankoop Toevoegen</h4>
      </div>
      <div class="modal-body">
        <form method="POST" action="${pageContext.request.contextPath}/InsertPurchase">
            <div class="form-group">
                
            </div>
           
            <div class="form-group">
                <label>Klant</label>
                <select name="klant"  class="form-control selectpicker" data-live-search="true">
                    <c:forEach items="${klantinfo}" var="info">
                    <option value="${info.id}"><c:out value="${info.id}" /> - <c:out value="${info.name}"/> <c:out value="${info.surname}"/> </option>
                     </c:forEach>
                </select>
                
            </div>
            <div class="form-group">
                <label>Product</label>
                <select name="product"  class="form-control selectpicker" data-live-search="true">
                    <c:forEach items="${productinfo}" var="info">
                    <option value="${info.id}"><c:out value="${info.id}" /> - <c:out value="${info.naam}"/> </option>
                     </c:forEach>
                </select>            </div>
            <div class="form-group">
                <label>Datum</label>
                <input type="date" name="date" class="form-control" value="${purchases.date}" />
            </div>
            <div class="form-group">
                <input type="submit" value="Submit" class="btn  btn-success"/>
                   <a href="index.html" class="btn btn-warning pull-right">Cancel</a>
            </div>

      </form>
      </div>
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
