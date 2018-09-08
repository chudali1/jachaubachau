<%@include file="../shared/header.jsp" %>
<%@include file="../shared/headlinkjsp.jsp" %>





Searched Items
<div class="container">
  <h2>Results</h2>
  <p>Symptoms:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Disease Name</th>
        <th>Probability</th>
        <th>Percentage</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="mapV" items="${ma}">
            <tr>
             <td> ${mapV.value}</td>
             <td> ${mapV.key} </td> 
            </tr>
        </c:forEach>
    </tbody>
                
  </table>
</div>

    <!-- /.box-body -->
</div>





<%@include file="../shared/footer.jsp" %>
