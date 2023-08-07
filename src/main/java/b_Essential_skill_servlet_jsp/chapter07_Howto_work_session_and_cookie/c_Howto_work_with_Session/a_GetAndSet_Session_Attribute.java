package b_Essential_skill_servlet_jsp.chapter07_Howto_work_session_and_cookie.c_Howto_work_with_Session;
/*
Chủ đề này hướng dẫn cách sử dụng API servlet để theo dõi phiên. Như đã đề cập trước đó,
để điều này hoạt động, người dùng phải bật cookie per-session trong trình duyệt của họ. May mắn thay,
thời nay hầu hết tất cả người dùng đều đã bật cookie per-session trong trình duyệt của họ.

Làm thế nào để set và get tính phiên (Session Attributes)

Hình 7-3:
getSession(); Phương thức này trả về đối tượng HttpSession được liên kết với yêu cầu này.
Nếu yêu cầu không liên kết với một phiên (session), phương thức này tạo một đối tượng
HttpSession mới và trả về nó.

- get Session
HttpSession session = request.getSession();

- Code that sets a String object as an attribute
session.setAttribute ("productCode", productCode);
- Code that sets a user-defined object as an attribute
Cart cart = new Cart(productCode);
session.setAttribute("cart", cart);

- Code that gets a String object 
String productCode = (String) session.getAttribute("productCode");
- Code that gets a user-defined object 
Cart cart = (Cart) session.getAttribute("cart");
if (cart == null) {
    cart = new Cart ();
}

- Code that removes an object 
session.removeAttribute ("productCode");

Hình 7-3 cho thấy cách lấy đối tượng phiên (session object) và cách lấy và thiết lập các
thuộc tính của đối tượng đó. Vì đối tượng phiên là một đối tượng JSP tích hợp sẵn,
bạn chỉ cần lấy đối tượng phiên khi làm việc với servlets. Để làm điều đó, bạn có thể gọi
phương thức getSession của đối tượng yêu cầu (request object),
như được thể hiện trong ví dụ đầu tiên. Sau đó, nếu đối tượng phiên chưa tồn tại,
phương thức này sẽ tạo một đối tượng phiên mới. Thông thường, nó chỉ truy cập đối tượng phiên
đã tồn tại nếu nó đã được tạo trước đó.

Từ đối tượng phiên, bạn có thể gọi phương thức setAttribute để thiết lập bất kỳ đối tượng nào
là một thuộc tính của phiên hiện tại. Để làm điều đó, bạn chỉ định một tên cho thuộc tính
và tên của đối tượng mà bạn muốn lưu trữ.
Ví dụ, các ví dụ thứ hai và thứ ba cho thấy cách lưu trữ một đối tượng String và một đối tượng Cart.
Ở đây, đối tượng Cart là một đối tượng kinh doanh (business object) lưu trữ tất cả các mục trong giỏ hàng của người dùng.

Tương tự, bạn có thể sử dụng phương thức getAttribute để trả về bất kỳ thuộc tính nào bạn đã thiết lập.
Để làm điều đó, bạn chỉ định tên của thuộc tính. Vì phương thức này trả về một đối tượng của kiểu Object,
bạn cần chuyển đổi từng đối tượng sang kiểu thích hợp, như được thể hiện trong các ví dụ thứ tư và thứ năm.

Trong chương 5, bạn đã học cách sử dụng các phương thức getAttribute và setAttribute của đối tượng
yêu cầu (request object). Bây giờ, bạn có thể thấy rằng các phương thức getAttribute và setAttribute
của đối tượng phiên hoạt động tương tự. Điểm khác biệt chính là phạm vi của các thuộc tính.
Khi bạn đặt một thuộc tính trong đối tượng yêu cầu, các thuộc tính sẽ bị xóa sau khi yêu cầu đã hoàn tất.
Tuy nhiên, khi bạn đặt một thuộc tính trong đối tượng phiên, các thuộc tính sẽ có sẵn cho đến khi
người dùng đóng trình duyệt, cho đến khi phiên hết hạn hoặc cho đến khi bạn sử dụng phương thức
removeAttribute để xóa một thuộc tính khỏi đối tượng phiên.

Nếu bạn làm việc với một ứng dụng web cũ hơn, bạn có thể thấy rằng nó sử dụng các phương thức
putValue, getValue và removeValue thay vì các phương thức setAttribute, getAttribute và removeAttribute.
Điều đó bởi vì các phương thức Attribute được giới thiệu từ phiên bản 2.2 của API servlet.
Tuy nhiên, các phương thức Value đã bị loại bỏ trong các phiên bản sau. Do đó, tất cả các ứng dụng web
mới nên sử dụng các phương thức Attribute.


Hình 7-4
getAttributeNames()
getId()
isNew()
setMaxInactiveinterval(int seconds)
invalidate()

Example:
Enumeration names = session.getAttributeNames();
while(names.hasMoreElements()) {
    System.out.println((String) names.nextElement());
}

A method that gets the ID for a session
String jSessionID = session.getId();

A method that sets inactive interval for a session
session.setInactiveInterval(60*60*24); // 1 day
session.setInactiveInterval(-1); // until the browser

A method that invalidates (vô hiệu hóa) the session and unbinds (bỏ ràng buộc) any objects
session.invalidate();



Các phương thức khác của đối tượng phiên (Session Object)

Hầu hết thời gian, bạn có thể sử dụng các phương thức được trình bày trong hình trước
để làm việc với đối tượng phiên. Tuy nhiên, hình 7-4 trình bày một số phương thức khác
của đối tượng phiên mà bạn có thể muốn sử dụng.

Bạn có thể sử dụng phương thức getAttributeNames của đối tượng phiên để trả về tên của
tất cả các thuộc tính được lưu trữ trong đối tượng phiên. Để làm điều đó, bạn sử dụng phương thức
getAttributeNames để trả về một đối tượng Enumeration. Sau đó, bạn có thể sử dụng các phương thức
hasMoreElements và nextElement của đối tượng Enumeration để lặp qua các tên như được
thể hiện trong ví dụ mã đầu tiên. Điều này có thể hữu ích cho việc gỡ lỗi.

Bạn có thể sử dụng phương thức getid để trả về ID mà động cơ servlet đang sử dụng cho phiên hiện tại.
ID này là một chuỗi dài định danh duy nhất cho mỗi phiên Java. Điều này cũng có thể hữu ích để gỡ lỗi
hoặc để làm cho đối tượng phiên an toàn đối với các luồng như được miêu tả trong hình tiếp theo.

Bạn có thể sử dụng phương thức isNew để kiểm tra xem khách hàng là mới hay nếu khách hàng
chọn không tham gia phiên. Phương thức này trả về giá trị true nếu khách hàng truy cập
trang web lần đầu tiên trong một phiên mới hoặc nếu cookie đã bị tắt trong trình duyệt.

Bạn có thể sử dụng hai phương thức cuối cùng để kiểm soát khi một phiên bị vô hiệu hóa.
Khi điều này xảy ra, tất cả các đối tượng đã được lưu trữ trong đối tượng phiên sẽ được ư
giải phóng khỏi đối tượng phiên. Mặc định, phiên bị vô hiệu hóa nếu người dùng không
hoạt động trong nửa giờ, nhưng bạn có thể sử dụng phương thức setMaxInactiveInterval
để thay đổi mặc định này. Ví dụ, nếu bạn cung cấp đối số là -1, đối tượng phiên sẽ không bị
vô hiệu hóa cho đến khi người dùng thoát trình duyệt.
Tuy nhiên, nếu cần thiết, bạn có thể gọi phương thức invalidate bất kỳ lúc nào bạn muốn vô hiệu hóa phiên.

Nếu bạn gọi một phương thức từ đối tượng phiên sau khi nó đã bị vô hiệu hóa,
phương thức đó sẽ ném ra một IllegalStateException.
*/
public class a_GetAndSet_Session_Attribute {
}
