<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <%@ include file="./commons/header2.jspf" %>
</head>

<body>
<%@ include file="./commons/navigation.jspf" %>

<div class="container" id="main">
    <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
        <div class="panel panel-default content-main">
            <form method="post" action="/JSPFinalProject/question">
                <input type="hidden" name="id" value="<%= sessionedUser.getId()%>">
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목"/>
                </div>
                <div class="form-group">
                    <label for="contents">내용</label>
                    <textarea name="contents" id="contents" rows="5" class="form-control"></textarea>
                </div>
                <button type="submit" class="btn btn-success clearfix pull-right">질문하기</button>
                <div class="clearfix" />
            </form>
        </div>
    </div>
</div>
</body>
</html>
