$("#form").on("click", ".btn", function () {
  $.ajax({
    url: "/api/users",
    type: "POST",
    dataType: "json",
    contentType: 'application/json;charset=utf-8',
    data: JSON.stringify({"name": $("#name").val(), "password": $("#password").val()}),
    success: function (result) {
      if (result.id) {
        alert("注册成功");
        window.location.href = "../index.html"
      } else {
        alert("用户名或者密码不对");
      }
    }
  })
})