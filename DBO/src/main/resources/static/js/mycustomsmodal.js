$(document).ready(function () {
	
	$('.openmodal').click(function(){
		var selection = $(this).data('item');
		if (selection == 'nickname') {
			$('#modalselection').text('* 닉네임에 적용된 아이템을 변경하시겠어요? *');
			$('.buyingwhat').text('변경하려는 아이템을 선택해주세요.');
			$('.moex').removeAttr('class').addClass('moex ' + $(this).data('item'));
			$('#modal-container').removeAttr('class').addClass('one');
  			$('body').addClass('modal-active');
  			$('.modalyes').css("display","unset");
  			$('.noc').text("돌아가기");
  		}
	});
	
	$('.confirmuse').click(function() {
		$('#useitem').val($(this).data('useitem'));
		$('#nouseitem').val($(this).data('nouseitem'));
		$('#itemuse').submit();
	});
	
	$('.noc').click(function(){
		$('#itemuse').val('');
		$('#itemnouse').val('');
  		$('#modal-container').addClass('out');
 		$('body').removeClass('modal-active');
	});
});
