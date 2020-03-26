$("#form").on("click", ".btn", function () {
  $.ajax({
    url: `/api/users?userName=${$("#name").val()}&password=${$("#password").val()}`,
    type: "GET",
    dataType: "json",
    success: function (result) {
      if (result.id) {
        alert("登录成功");
      } else {
        alert("用户名或者密码不对");
      }
    }
  })
})