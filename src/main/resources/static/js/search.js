function searchByKeyWord() {
    var keyword = $("#key").val();
    document.getElementById("search").href="/share/links/search/bykeyword?keyword="+keyword+"&pagenum=1";
}
