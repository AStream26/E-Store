<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${requestScope.message != null}">
    
    <div class="alert alert-warning alert-dismissible fade show alertMessage " style="position:absolute;width: 100%;z-index: 10;" role="alert">
        <div class="text-center">
            <strong >
            <%=
                request.getAttribute("message")
                
            %>
        </strong>
        </div>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
          
</c:if>


  <% 
            request.removeAttribute("message");
  %>

