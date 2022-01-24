<#import "parts/common.ftlh" as c>
<@c.page>

    <h4>${user.nickname}, it's your profile </h4>
    <nav class="navbar navbar-dark bg-light col-sm-5">
        <div class="container-fluid">
        <div class="form-group col-md-6">
            <form action="profile" method="post">
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Nickname: </label>
                <div class="col-sm-5">
                    <input type="text" name="nickname" value="${nickname}"></label>
                </div>

                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Email: </label>
                <div class="col-sm-5">
                <input type="text" name="email" value="${email}"></label>
                </div>
                <input type="hidden" value="${_csrf.token}" name = "_csrf">
                <button type="submit" class="btn btn-primary ml-2 mt-2">Save</button>
            </form>
        </div>
        </div>
    </nav>




</@c.page>