$(".arrows").mouseover(function() {
  $(this).attr("src", $(this).data("animated"))
}),
$(".arrows").mouseout(function() {
  $(this).attr("src", $(this).data("static"))
});

function goPage(page) {
	location.href = '/' + page;
}


function goSpecificPage(page) {
	if (page == 'nicknameshop') {
		location.href = "/mycustoms";
	} else if (page == 'customs') {
		location.href = "/myItemShop";
	}
}

