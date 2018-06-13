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
        <li role="presentation"><a href="History">Verkoop</a></li>
        <li role="presentation" class="active"><a href="Tests">Oogmetingen</a></li>
        </ul>
                        <h1>Oogmetingen Overzicht</h1>

            <div class="container">
                
                <div class="row">
         <p style="color: red;">${errorString}</p>
        <table  class="table" id="example">
            
            <thead>
       <tr>
          <th>#</th>
          <th>klant Naam</th>
          <th>klant Achternaam</th>
          <th>OD Sterkte</th>
          <th>OD Cylinder</th>
          <th>OD AS</th>
          <th>OS Sterkte</th>
          <th>OS Cylinder</th>
          <th>OS AS</th>
       </tr>
       </thead>
        <tbody>
       <c:forEach items="${Tests}" var="test">
        <tr>
            <td>${test.id}</td>
            <td><c:out value="${test.name}" /></td>
             <td><c:out value="${test.surname}" /></td>
            <td><c:out value="${test.r_sterkte}" /></td>
            <td><c:out value="${test.r_cylinder}" /></td>
            <td><c:out value="${test.r_as}" /></td>
            <td><c:out value="${test.l_sterkte}" /></td>
            <td><c:out value="${test.l_cylinder}" /></td>
            <td><c:out value="${test.l_as}" /></td>

        </tr>
         
    </c:forEach>
        </tbody>
        

    </table>
        </div>
         <input type="submit" value="Tests Toevoegen" class="btn  btn-info" data-toggle="modal" data-target="#TestsModal"/>
          <div id="TestsModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Tests</h4>
      </div>
      <div class="modal-body">
          <form method="POST" action="${pageContext.request.contextPath}/InsertTests">
            <div class="row ">  
                <div class="col-md-12">
                <div class="form-group">
                <label>Klant</label>
                <select name="klant"  class="form-control selectpicker" data-live-search="true">
                    <c:forEach items="${klantinfo}" var="info">
                    <option value="${info.id}"><c:out value="${info.id}" /> - <c:out value="${info.name}"/> <c:out value="${info.surname}"/> </option>
                     </c:forEach>
                </select>
            </div>
                </div>
                    <div class="col-md-6" style="padding-right:20px; border-right: 1px solid #ccc;">
                        <div class="form-group">
                            <label>OD Sterkte</label>
                            <input type="text" name="rsterkte" class="form-control" value="${tests.r_sterkte}" required="true"/>

                        </div>
                        <div class="form-group">
                            <label>OD Cylinder</label>
                            <input type="text" name="rcylinder" class="form-control" value="${tests.r_cylinder}" required="true"/>
                        </div>
                        <div class="form-group">
                            <label>OD AS</label>
                            <input type="text" name="ras" class="form-control" value="${tests.r_as}" required="true"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>OS Sterkte</label>
                            <input type="text" name="lsterkte" class="form-control" value="${tests.l_sterkte}" required="true"/>

                        </div>
                        <div class="form-group">
                            <label>OS Cylinder</label>
                            <input type="text" name="lcylinder" class="form-control" value="${tests.l_cylinder}" required="true"/>
                        </div>
                        <div class="form-group">
                            <label>OS AS</label>
                            <input type="text" name="las" class="form-control" value="${tests.l_as}" required="true"/>
                        </div>
                    </div>
                        <div class="col-md-12">
                <div class="form-group">
                    <input type="submit" value="Submit" class="btn  btn-success"/>
                       <a href="Tests" class="btn btn-warning pull-right">Cancel</a>
                </div>
            </div>
            
             </form>
      
      </div>
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
