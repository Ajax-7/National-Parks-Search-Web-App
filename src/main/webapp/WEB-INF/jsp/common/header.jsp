<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
    <header>
    	<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Park Geek logo" />
        </a>        <h1>National Parks</h1>
    </header>
    <nav>
   
        <ul>
        		
        		<c:url value="/" var="homePage" />
            <li><a href="${homePage}">Home</a></li>
            <c:url value="/surveyPage" var="surveyPage"/>
            <li><a href="${surveyPage}">Survey</a></li>
            <c:url value="/favParksPage" var="favParksPage" />
            <li><a href="${favParksPage}">Top Parks</a></li>  
                        
        </ul>
    </nav>