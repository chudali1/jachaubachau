<%@include file="../shared/header.jsp" %>
<%@include file="../shared/headlinkjsp.jsp" %>
Searched Items
<div class="box">
            <div class="box-header">
                <h1 class="box-title">Result based on symptoms</h1>
                <h2>${selectbasic} ${radios} ${symptom}</h2>
              
            </div>
    Disease Diagnosed as :<h1> ${result}</h1>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-striped">
                  
                  <thead>
                  <th>Disease</th>
                  <th>Probability</th>
                  </thead>
                  
                  <tbody>
                     
                      <c:forEach items="${other}" var="oth">             
                      <tr>
                          <td>${oth.category}</td>
                          <td>${oth.probability}</td>
                      </tr>
                      </c:forEach>
                  </tbody>
                
             </table>
            </div>
            <!-- /.box-body -->
          </div>





<%@include file="../shared/footer.jsp" %>
