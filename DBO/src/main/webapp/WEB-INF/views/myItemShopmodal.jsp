<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="modal-container">
	<div class="modal-background">
		<div class="modal">
			<h2 id="modalselection"></h2>
			<div class="modallayout">
				<div class="motitle">
					<p class="buyingwhat"></p>
					<p class="howmuch"></p>
				</div>
				<div>
					<div class="moex"><span id="spanexplain"></span></div>
				</div>
				<div class="modalconfirm">
					<div class="modalyes"><span class="modalbtn yesc cursorPointer">예</span></div>
					<div class="modalno"><span class="modalbtn noc cursorPointer">아니오</span></div>
				</div>
				<form id="itembuy" action="/itembuy" method="post">
					<input type="hidden" name="item" id="item"/>
					<input type="hidden" name="price" id="price"/>
				</form>
			</div>
		</div>
	</div>
	
</div>