<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.chimera.org/chimera.tld" prefix="p" %>
<p:html titulo="Mantenimiento de Usuario" javascript="">
<script type="text/javascript">
<!--
function Pager(tableName, itemsPerPage) {
    this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;
    
    this.showRecords = function(from, to) {        
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 1; i < rows.length; i++) {
            if (i < from || i > to)  
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    }
    
    this.showPage = function(pageNumber) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}

        var oldPageAnchor = document.getElementById('pg'+this.currentPage);
        oldPageAnchor.className = 'pg-normal';
        
        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage);
        newPageAnchor.className = 'pg-selected';
        
        var from = (pageNumber - 1) * itemsPerPage + 1;
        var to = from + itemsPerPage - 1;
        this.showRecords(from, to);
    }   
    
    this.prev = function() {
        if (this.currentPage > 1)
            this.showPage(this.currentPage - 1);
    }
    
    this.next = function() {
        if (this.currentPage < this.pages) {
            this.showPage(this.currentPage + 1);
        }
    }                        
    
    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length - 1); 
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    }

    this.showPageNav = function(pagerName, positionId) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}
    	var element = document.getElementById(positionId);
    	
    	var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal"> &#171 Prev </span> | ';
        for (var page = 1; page <= this.pages; page++) 
            pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';
        pagerHtml += '<span onclick="'+pagerName+'.next();" class="pg-normal"> Next &#187;</span>';            
        
        element.innerHTML = pagerHtml;
    }
}


//-->
</script>
Mantenimiento de Usuario





<form action="" method="get" enctype="application/x-www-form-urlencoded">
        <table id="results">
            <tbody><tr>
                <th>#</th>
                <th>field</th>
            </tr>
            <tr style="">
                <td>1</td>
                <td><input type="text" name="field-name" value="rec1"></td>
            </tr>
            <tr style="">
                <td>2</td>
                <td><input type="text" name="field-name" value="rec2"></td>
            </tr>
            <tr style="">
                <td>3</td>
                <td><input type="text" name="field-name" value="rec3"></td>
            </tr>
            <tr style="display: none; ">
                <td>4</td>
                <td><input type="text" name="field-name" value="rec4"></td>
            </tr>
            <tr style="display: none; ">
                <td>5</td>
                <td><input type="text" name="field-name" value="rec5"></td>
            </tr>
            <tr style="display: none; ">
                <td>6</td>
                <td><input type="text" name="field-name" value="rec6"></td>
            </tr>
            <tr style="display: none; ">
                <td>7</td>
                <td><input type="text" name="field-name" value="rec7"></td>
            </tr>
            <tr style="display: none; ">
                <td>8</td>
                <td><input type="text" name="field-name" value="rec8"></td>
            </tr>
            <tr style="display: none; ">
                <td>9</td>
                <td><input type="text" name="field-name" value="rec9"></td>
            </tr>
            <tr style="display: none; ">
                <td>10</td>
                <td><input type="text" name="field-name" value="rec10"></td>
            </tr>
        </tbody></table>
        <div id="pageNavPosition"><span onclick="pager.prev();" class="pg-normal"> « Prev </span> | <span id="pg1" class="pg-selected" onclick="pager.showPage(1);">1</span> | <span id="pg2" class="pg-normal" onclick="pager.showPage(2);">2</span> | <span id="pg3" class="pg-normal" onclick="pager.showPage(3);">3</span> | <span id="pg4" class="pg-normal" onclick="pager.showPage(4);">4</span> | <span onclick="pager.next();" class="pg-normal"> Next »</span></div>
        <div><input type="submit" onclick="alert('Hey, this is just a sample!'); return false;">&nbsp;<input type="reset"></div>
    </form>
















<script type="text/javascript"><!--
        var pager = new Pager('results', 3); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>


</p:html>
