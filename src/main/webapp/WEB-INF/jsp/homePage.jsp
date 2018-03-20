<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<section class="container">
	<div>
		<c:forEach var="park" items="${allParks}">
			<div class="row">
				<div class="col-12 col-md-6">

					<c:url var="parkPic" value="${park.parkImg}" />
					<c:url var="parkDetail" value="/${park.parkCode}" />
					<a href="${parkDetail}"> <img src="${parkPic}"
						alt="${park.parkName}" class="img-fluid">
					</a>

				</div>

				<div class="col-12 col-md-6 park-details">

					<div>
						<h3>
							<c:out value="${park.parkName}" />
						</h3>
					</div>
					<div class="park-detail-small">
						<div>
							<strong>State: </strong>
							<c:out value="${park.state}" />
						</div>
						<div>
							<strong>Acreage: </strong>
							<c:out value="${park.acreage}" />
						</div>
						<div>
							<strong>Elevation: </strong>
							<c:out value="${park.elevationInFeet} ft" />
						</div>
						<div>
							<strong>Trail Length: </strong>
							<c:out value="${park.milesOfTrail} mi" />
						</div>
						<div>
							<strong>Number of Campsites: </strong>
							<c:out value="${park.numberOfCampsites}" />
						</div>
						<div>
							<strong>Climate: </strong>
							<c:out value="${park.climate}" />
						</div>
						<div>
							<strong>Founded Year: </strong>
							<c:out value="${park.yearFounded}" />
						</div>
						<div>
							<strong>Annual Visitor Count: </strong>
							<c:out value="${park.annualVisitorCount} " />
						</div>
						<div>
							<strong>Quote: </strong>
							<c:out value="${park.inspirationalQuote}" />
							<c:out value="${park.inspirationalQuoteSource}" />
						</div>
						<div>
							<strong>Entry Fee: </strong><
							<c:out value="${park.entryFee}" />
						</div>
						<div>
							<strong>Number of Animal Species </strong><
							<c:out value="${park.numberOfAnimalSpecies}" />
						</div>
					</div>
					<div>
						<c:out value="${park.parkDescription}" />
					</div>


				</div>
			</div>


		</c:forEach>
	</div>



</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />