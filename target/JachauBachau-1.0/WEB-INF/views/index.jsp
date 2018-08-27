<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.cab.jachaubachau.entity.Symptoms"%>
<%@page import="com.cab.jachaubachau.dao.impl.SymptomsDaoImpl"%>
<%@page import="com.cab.jachaubachau.dao.SymptomsDao"%>
<%@include file="../shared/header.jsp" %>
<div class="container-fluid">

    <!-- SELECT2 EXAMPLE -->
    <div class="card card-default">
        <div class="card-header">
            <h3 class="card-title"></h3>
            <form action="${pageContext.request.contextPath}/submitSearch" method="POST">
            <div class="form-group">
                <label class="col-md-4 control-label" for="selectbasic">Select Age Group</label>
                <div class="col-md-4">
                    <select id="selectbasic" name="selectbasic" class="form-control">
                        <option value="Child">Child</option>
                        <option value="Adult">Adult</option>
                        <option value="Elderly">Elderly</option>
                    </select>
                </div>
            </div>

            <form class="form-horizontal">
                <fieldset>
                    <!-- Multiple Radios (inline) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="radios">Gender</label>
                        <div class="col-md-4"> 
                            <label class="radio-inline" for="radios-0">
                                <input type="radio" name="radios" id="radios-0" value="male" checked="checked">
                                Male
                            </label> 
                            <label class="radio-inline" for="radios-1">
                                <input type="radio" name="radios" id="radios-1" value="female">
                                Female
                            </label> 
                            <label class="radio-inline" for="radios-2">
                                <input type="radio" name="radios" id="radios-2" value="other">
                                Other
                            </label>
                        </div>
                    </div>

                </fieldset>
          


            <!-- /.col -->
            <div class="col-md-6">
                                    

                <div class="form-group">
                    <label>Search Here</label>
                </div>
                <select class="form-control select2" name="symptom" multiple="multiple" data-placeholder="Select a symptoms"
                        style="width: 100%;" > 


                    <%
                        try {
                            String query = "select * from symptoms";
                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            Connection conn = DriverManager
                                    .getConnection("jdbc:mysql://localhost/jachaubachau",
                                            "root",
                                            "");
                            Statement stm = conn.createStatement();
                            ResultSet rs = stm.executeQuery(query);
                            while (rs.next()) {
                    %>
                    <option value="<%=rs.getString("s_name")%>"><%=rs.getString("s_name")%> </option>
                    <%

                            }

                        } catch (Exception e) {
                        }


                    %>



                </select>
                <span class="input-group-append">
                    <input type="submit" class="btn btn-primary" value="Search Now" >
                      
                  
                </form> 

                                <!-- /.form-group -->
                            </div>






                            <!-- /.col -->
                        </div>


                        <!-- /.row -->
                    </div>

                    <%@include file="../shared/footer.jsp" %>