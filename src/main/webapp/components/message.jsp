<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:if test='${requestScope.message != null}'>
    <div class="alert alert-warning alert-dismissible fade show" style="z-index: 10;" role="alert">
        <div class="text-center">
            <strong>
                ${requestScope.message}
            </strong>
        </div>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>


    <c:if test='${requestScope.messageFrom.equals("admin") == true}'>
        <script>
            history.pushState(null, null, './admin/');
        </script>
    </c:if>
</c:if>

        
<% 

    request.removeAttribute("message");
%>




