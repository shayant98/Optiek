<%-- 
    Document   : klanten.jsp
    Created on : Oct 30, 2017, 9:14:10 PM
    Author     : Shayant
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
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klanten Overzicht</title>
    </head>
    <body>
        
        <div class="col-md-12">
            <ul class="nav nav-tabs navbar-primary">
        <li role="presentation"><a href="index.html">Home</a></li>
        <li role="presentation" class="active"><a href="Klanten">Klanten</a></li>
        <li role="presentation"><a href="Producten">Producten</a></li>
        <li role="presentation"><a href="History">Verkoop</a></li>
        <li role="presentation"><a href="Tests">Oogmetingen</a></li>
        </ul>
            <h1>Klanten Overzicht</h1>
            <div class="container">
                <div class="row">
         <p style="color: red;">${errorString}</p>
        <table  class="table" id="example">
            
            <thead>
       <tr>
          <th>#</th>
          <th>ID</th>
          <th>Voornaam</th>
          <th>Achternaam</th>
          <th>Geslacht</th>
          <th>Geboortedatum</th>
          <th>Functions</th>
       </tr>
       </thead>
        <tbody>
       <c:forEach items="${klanten}" var="klant">
        <tr>
            <td>${klant.id}</td>
            <td><c:out value="${klant.id_number}" /></td>
            <td><c:out value="${klant.name}" /></td>
            <td><c:out value="${klant.surname}" /></td>
             <td><c:out value="${klant.gender}" /></td>
             <td><c:out value="${klant.birthday}" /></td>
             <td>
                 <div class="btn-group" role="group" aria-label="...">
                    <a href="PurchaseHistory?code=${klant.id}" class="btn btn-success "><i class="fa fa-shopping-cart " aria-hidden="true"> </i> Verkoop</a>
                <a href="KlantTests?code=${klant.id}" class="btn btn-success "><i class="fa fa-eye" aria-hidden="true"> </i>  Oogmetingen</a>

                    <div class="btn-group" role="group">
                      <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Extra
                        <span class="caret"></span>
                      </button>
                      <ul class="dropdown-menu">
                          <li class="danger"><a href="DeleteKlant?code=${klant.id}"><i class="fa fa-trash-o " aria-hidden="true"></i> Delete</a></li>
                      </ul>
                    </div>
                  </div>
             </td>
        </tr>
         
    </c:forEach>
        </tbody>
        

    </table>
       </div>
         
          <input type="submit" value="Klant Registreren" class="btn  btn-info" data-toggle="modal" data-target="#klantenModal"/>
          <div id="klantenModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Klant </h4>
      </div>
      <div class="modal-body">
        <form method="POST" action="${pageContext.request.contextPath}/InsertKlant">
            <div class="form-group">
                
            </div>
            <div class="form-group">
                <label>ID</label>
                <input type="text" name="id"  class="form-control" value="${klant.code}" />
            </div>
            <div class="form-group">
                <label>Voornaam</label>
                <input type="text" name="name" class="form-control" value="${klant.name}" />
                
            </div>
            <div class="form-group">
                <label>Achternaam</label>
                <input type="text" name="surname" class="form-control" value="${klant.surname}" />
            </div>
            <div class="form-group">
                <label>geslacht</label>
                <input type="text" name="gender" class="form-control" value="${klant.gender}" />
            </div>
            <div class="form-group">
                <label>Geboortedatum</label>
                <input type="date" name="birthday" class="form-control" value="${klant.birthday}" />
            </div>
            <div class="form-group">
                <input type="submit" value="Submit" class="btn  btn-success"/>
                   <a href="Klanten" class="btn btn-warning pull-right">Cancel</a>
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
            } );
</script>
</html>

