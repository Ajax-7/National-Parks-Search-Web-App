<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="container">
	<div class="row">
		<div class="col-12">
			<h1>Top Parks</h1>
		</div>
	</div>
	<c:forEach var="park" items="${allParks}">
		<div class="row fav-parks-item">
			<div class="col-12 col-md-3">

				<c:url var="parkPic" value="${park.parkImg}" />
				<img src="${parkPic}" alt="${park.parkName}" class="img-fluid">

			</div>
			<div class="col-12 col-md-6">
				<h3>
					<c:out value="${park.parkName}" />
				</h3>
			</div>
			<div class="col-12 col-md-3">
				<strong>Votes: </strong><c:out value="${park.favParkCount}" />
			</div>
		</div>
	</c:forEach>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />