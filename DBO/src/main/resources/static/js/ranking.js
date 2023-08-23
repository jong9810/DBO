function goSpecificWeek(year, weekNumber) {
	const jan1 = new Date(year, 0, 1);
	const daysToMonday = (7 - jan1.getDay() + 1) % 7;
	const startOfYear = new Date(year, 0, 1 + daysToMonday);
	const startDate = new Date(startOfYear.getTime() + (weekNumber - 1) * 7 * 24 * 60 * 60 * 1000);

	const startYear = startDate.getFullYear();
	const startMonth = startDate.getMonth() + 1;
	const startDay = startDate.getDate();

	location.href = "/ranking?year=" + startYear + "&month=" + startMonth + "&day=" + startDay;
}

$(".arrows").mouseover(function() {
  $(this).attr("src", $(this).data("animated"))
}),
$(".arrows").mouseout(function() {
  $(this).attr("src", $(this).data("static"))
});

function goPage(page) {
	location.href = "/" + page;
}