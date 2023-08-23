//시간 더 주면 오래 보여짐
$(window).on('load', ()=>{
	setTimeout("closeLoadingWithMask()", 500);
});

//로딩 애니메이션 div 없애기
function closeLoadingWithMask() {
    $('#mask').fadeOut(600);
    $('#mask').empty();
}
