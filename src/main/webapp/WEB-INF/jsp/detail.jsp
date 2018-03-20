<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="container">

	<div class="row">
		<div class="col-12">
			<c:url var="parkPic" value="${park.parkImg}" />
			<img class="img-fluid img-stretch" src="${parkPic}" alt="${park.parkName}">
			<h1>
				<c:out value="${park.parkName}" />
			</h1>
			<p>
				<c:out value="${park.parkDescription}" />
			</p>

		</div>

	</div>

	<div class="row">


		<div class="col-12 col-md-3">
			<c:set var="mainDay" value="${weatherRange.get(0)}" />

			<h3>Today</h3>
			<c:url var="weatherPic" value="${mainDay.image}" />
			<img class="img-fluid"  src="${weatherPic}" alt="weather picture" />



			<div>
				<h6>
					High
					<c:if test="${celcius}">
						<c:out value="${mainDay.highCelcius}" />
					</c:if>
					<c:if test="${!celcius}">
						<c:out value="${mainDay.highFahrenheit}" />
					</c:if>
				</h6>
				<h6>
					Low
					<c:if test="${celcius}">
						<c:out value="${mainDay.lowCelcius}" />
					</c:if>
					<c:if test="${!celcius}">
						<c:out value="${mainDay.lowFahrenheit}" />
					</c:if>
				</h6>
			</div>

			<p>
				<c:out value="${mainDay.alert}" />
				<c:out value="${celcius}" />
			</p>

		</div>

		<div class="col-12 col-md-9">
			<div class="row">
				<c:forEach begin="1" end="4" var="dayNum">
					<div class="col-12 col-md-3">
						<c:set var="day" value="${weatherRange.get(dayNum)}" />
						<c:url var="weatherPic" value="${day.image}" />
						<img class="img-fluid" src="${weatherPic}" alt="weather picture" />
						<div>
							<h6>
								High
								<c:if test="${celcius}">
									<c:out value="${mainDay.highCelcius}" />
								</c:if>
								<c:if test="${!celcius}">
									<c:out value="${mainDay.highFahrenheit}" />
								</c:if>

							</h6>
							<h6>
								Low
								<c:if test="${celcius}">
									<c:out value="${day.lowCelcius}" />
								</c:if>
								<c:if test="${!celcius}">
									<c:out value="${day.lowFahrenheit}" />
								</c:if>
							</h6>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<c:url var="formAction" value="/${parkCode}" />
				<form method="POST" action="${formAction}">
					<label for="celcius">Celcius or Fahrenheit?</label> <span><input
						type="radio" name="celcius" value="false" />Fahrenheit</span> <span><input
						type="radio" name="celcius" value="true" />Celcius</span> <input
						type="hidden" value="${parkCode}" /> <input type="submit"
						value="Change Temp Type" />

				</form>
			</div>
		</div>


	</div>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />