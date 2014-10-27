FreeMarker
=========================
###### Simple Sample
1. create a book class
2. ${book.name?if_exists}
3. ${book.name?default('defaultname')}
4. ${book.name!"xxx} --default value
5. data format : ${book.date?string('yyyy-mm-dd')}
6. number format :
    ${book?string.number} --20
    ${book?string.currency}--<#-- $20.00 -->
    ${book?string.percent}—<#-- 20% -->
7. boolean:
   <#assign foo=true />
   ${foo?string("yes","no")} <#-- yes -->

###### Logical Controller
1. if condition
    <#if condition>...
    <#elseif condition2>...
    <#elseif condition3>......
    <#else>...
    其中空值判断可以写成<#if book.name?? >

    </#if>
2. switch case
    <#switch value>
    <#case refValue1>
        ...
        <#break>
    <#case refValue2>
        ...
        <#break>
    ...
    <#case refValueN>
        ...
        <#break>
    <#default>
        ...
    </#switch>

3．循环读取
    <#list sequence as item>
    ...
    </#list>
    空值判断<#if bookList?size = 0></#list>
    e.g.
    <#list employees as e>
    ${e_index}. ${e.name}
    </#list>
    输出:
    1. Readonly
    2. Robbin
