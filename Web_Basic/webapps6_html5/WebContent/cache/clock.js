function setClock() {
	var now = new Date();
	document.getElementById('msg').innerHTML=now.toLocaleString();
	setTimeout('setClock()', 1000);
}