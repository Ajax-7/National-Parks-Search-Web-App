<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="container">
	<div class="row">
		<div class="col-12">
			<h1>Welcome to the National Park Survey</h1>
			<p>Tell us what your favorite Park is and you could win a pet
				polar bear. Just kidding... that's illegal.</p>
		</div>
	</div>

	<div class="row">
	<div class="col-12">

		<c:url var="formAction" value="/surveyPage" />
		<form method="POST" action="${formAction}">

			<div class="row">
				<div class="col-12 col-md-3">
					<label for="favNatPark">Favorite National Park </label>
				</div>
				<div class="col-12 col-md-9">
					<select id="favNatPark" name="favNatPark">
						<c:forEach var="park" items="${allParks}">
							<option value="${park.parkCode}"><c:out
									value="${park.parkName}" /></option>
						</c:forEach>

					</select>
				</div>
			</div>


			<div class="row">
				<div class="col-12 col-md-3">
					<label for="yourEmail">Your Email</label>
				</div>
				<div class="col-12 col-md-9">
					<input type="email" id="yourEmail" name="yourEmail" />
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-md-3">
					<label for="state">State of Residence</label>
				</div>
				<div class="col-12 col-md-9">

					<select id="state" name="state">
						<c:forEach var="state" items="${allStates}">
							<option value="${state}"><c:out value="${state}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-md-3">

					<label for="activityLevel">Activity Level</label>
				</div>
				<div class="col-12 col-md-9">

					<span><input type="radio" name="activityLevel"
						value="inactive" />Inactive</span> <span><input type="radio"
						name="activityLevel" value="sedentary" />Sedentary</span> <span><input
						type="radio" name="activityLevel" value="active" />Active</span> <span><input
						type="radio" name="activityLevel" value="extremely active" />Extremely
						Active</span>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
		</div>
	</div>

</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />