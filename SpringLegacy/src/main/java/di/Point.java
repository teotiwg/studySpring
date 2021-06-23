package di;

// 그래프 상에서 하나의 좌표값을 표현하는 클래스
public class Point {
	public int x;
	public int y;
	
	// 생성자 메소드만 정의함
	public Point(int x,  int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	// 객체의 참조변수를 그대로 출력하면 toString()의 내용이 출력됌
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(x, y) = %d, %d, ", x, y);
	}
}
