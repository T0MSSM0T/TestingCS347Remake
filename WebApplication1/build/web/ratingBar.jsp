<%-- 
    Document   : ratingBar
    Created on : Dec 11, 2016, 3:25:40 PM
    Author     : hirstrb
--%>

<%@page import="java.util.Collections"%>
<%@page import="Model.Rating"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean class="Model.Rating" id="ratingList" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rating Bar</title>
    </head>
    <body>
        <!-- http://www.jquery2dotnet.com/ -->
        <%
            ArrayList<Rating> ratings = ratingList.getRatingsBySite((int) session.getAttribute("siteid"));
            session.setAttribute("ratingTotal", ratings.size());
            int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, total = 0;

            for (int ii = 0; ii < ratings.size(); ii++) {

                total += ratings.get(ii).getRating();

                if (ratings.get(ii).getRating() == 1) {
                    ones++;
                } else if (ratings.get(ii).getRating() == 2) {
                    twos++;
                } else if (ratings.get(ii).getRating() == 3) {
                    threes++;
                } else if (ratings.get(ii).getRating() == 4) {
                    fours++;
                } else {
                    fives++;
                }
            }

            session.setAttribute("ones", ones);
            session.setAttribute("twos", twos);
            session.setAttribute("threes", threes);
            session.setAttribute("fours", fours);
            session.setAttribute("fives", fives);

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add((int) session.getAttribute("ones"));
            list.add((int) session.getAttribute("twos"));
            list.add((int) session.getAttribute("threes"));
            list.add((int) session.getAttribute("fours"));
            list.add((int) session.getAttribute("fives"));

            int max = 0, count = 0;
            for (int ii = 0; ii < list.size(); ii++) {
                if (list.get(ii) > max) {
                    max = list.get(ii);
                    count = ii;
                }
            }

            session.setAttribute("averageRating", count + 1);
            session.setAttribute("perFive", (Double.parseDouble(session.getAttribute("fives").toString()) / Double.parseDouble(session.getAttribute("ratingTotal").toString()) * 100.0));
            session.setAttribute("perFour", (Double.parseDouble(session.getAttribute("fours").toString()) / Double.parseDouble(session.getAttribute("ratingTotal").toString()) * 100.0));
            session.setAttribute("perThree", (Double.parseDouble(session.getAttribute("threes").toString()) / Double.parseDouble(session.getAttribute("ratingTotal").toString()) * 100.0));
            session.setAttribute("perTwo", (Double.parseDouble(session.getAttribute("twos").toString()) / Double.parseDouble(session.getAttribute("ratingTotal").toString()) * 100.0));
            session.setAttribute("perOne", (Double.parseDouble(session.getAttribute("ones").toString()) / Double.parseDouble(session.getAttribute("ratingTotal").toString()) * 100.0));
        %>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="well well-sm">
                        <div class="row">
                            <div class="col-xs-12 col-md-6 text-center">
                                <h1 class="rating-num">
                                    <%=session.getAttribute("averageRating")%> </h1>
                                <div class="rating">

                                    <%
                                        for (int ii = 0; ii < (int) session.getAttribute("averageRating"); ii++) {
                                            out.println("<span class=\"glyphicon glyphicon-star\"> </span>");
                                        }

                                        for (int ii = 0; ii < 5 - (int) session.getAttribute("averageRating"); ii++) {
                                            out.println("<span class=\"glyphicon glyphicon-star-empty\"> </span>");
                                        }
                                    %>

                                </div>
                                <div>
                                    <span class="glyphicon glyphicon-user"></span> <%=session.getAttribute("ratingTotal") + " ratings total"%>
                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6">
                                <div class="row rating-desc">
                                    <div class="col-xs-3 col-md-3 text-right">
                                        <span class="glyphicon glyphicon-star"></span>5
                                    </div>
                                    <div class="col-xs-8 col-md-9">
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                                 aria-valuemin="0" aria-valuemax="100" style="width: <%=session.getAttribute("perFive")%>%">
                                                <span class="sr-only"><%=session.getAttribute("fives")%></span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 5 -->
                                    <div class="col-xs-3 col-md-3 text-right">
                                        <span class="glyphicon glyphicon-star"></span>4
                                    </div>
                                    <div class="col-xs-8 col-md-9">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                                 aria-valuemin="0" aria-valuemax="100" style="width: <%=session.getAttribute("perFour")%>%">
                                                <span class="sr-only"><%=session.getAttribute("fours")%></span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 4 -->
                                    <div class="col-xs-3 col-md-3 text-right">
                                        <span class="glyphicon glyphicon-star"></span>3
                                    </div>
                                    <div class="col-xs-8 col-md-9">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                                                 aria-valuemin="0" aria-valuemax="100" style="width: <%=session.getAttribute("perThree")%>%">
                                                <span class="sr-only"><%=session.getAttribute("threes")%></span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 3 -->
                                    <div class="col-xs-3 col-md-3 text-right">
                                        <span class="glyphicon glyphicon-star"></span>2
                                    </div>
                                    <div class="col-xs-8 col-md-9">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="20"
                                                 aria-valuemin="0" aria-valuemax="100" style="width: <%=session.getAttribute("perTwo")%>%">
                                                <span class="sr-only"><%=session.getAttribute("twos")%></span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 2 -->
                                    <div class="col-xs-3 col-md-3 text-right">
                                        <span class="glyphicon glyphicon-star"></span>1
                                    </div>
                                    <div class="col-xs-8 col-md-9">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                                 aria-valuemin="0" aria-valuemax="100" style="width: <%=session.getAttribute("perOne")%>%">
                                                <span class="sr-only"><%=session.getAttribute("ones")%></span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 1 -->
                                </div>
                                <!-- end row -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
