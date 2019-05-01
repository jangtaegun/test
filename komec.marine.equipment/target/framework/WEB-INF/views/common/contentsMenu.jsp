<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
 <ul id="nav">
            <li><a href="#1">Item 1</a>
                <ul>
                    <li><a href="<c:url value= "/codeList.do"/>">코드관리</a></li>
                    <li><a href="#">Sub-Item 1 b</a></li>
                    <li><a href="#">Sub-Item 1 c</a></li>
                </ul>
            </li>
            <li><a href="#2">Item 2</a>
                <ul>
                    <li><a href="#">Sub-Item 2 a</a></li>
                    <li><a href="#">Sub-Item 2 b</a></li>
                </ul>
            </li>
            <li><a href="#3">Item 3</a>
                <ul>
                    <li><a href="#">Sub-Item 3 a</a></li>
                    <li><a href="#">Sub-Item 3 b</a></li>
                    <li><a href="#">Sub-Item 3 c</a></li>
                    <li><a href="#">Sub-Item 3 d</a></li>
                </ul>
            </li>
             <li><a href="#4">Item 4</a>
                <ul>
                    <li><a href="#">Sub-Item 3 a</a></li>
                    <li><a href="#">Sub-Item 3 b</a></li>
                    <li><a href="#">Sub-Item 3 c</a></li>
                    <li><a href="#">Sub-Item 3 d</a></li>
                </ul>
            </li>
        </ul> 