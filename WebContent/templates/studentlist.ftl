<tr>
		<td>序号</td>
		<td>姓名</td>
		<td>密码</td>
		<td>操作</td>
	</tr>
	<#if mylist?exists>
    <#list mylist as student>
	<tr id="${student.id}">
		<td>${student.id}</td>
		<td>${student.user}</td>
		<td>${student.psw}</td>
		<td>
			<input type="button" value="编辑"/> &nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="del('${student.id}')" value="删除"/>
		</td>
	</tr>
</#list>
</#if>