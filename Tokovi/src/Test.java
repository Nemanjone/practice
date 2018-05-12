import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	private Subject subject;
	private Student student;
	private Date date;
	private Double mark;
	
	
	public Test(Subject subject, Student student, Date date, Double mark) {
		super();
		this.setSubject(subject);
		this.setStudent(student);
		this.setDate(date);
		this.setMark(mark);
	}
	
	public Test(Subject subject, Student student, String date, Double mark) throws ParseException {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.setSubject(subject);
		this.setStudent(student);
		this.setDate(sdf.parse(date));
		this.setMark(mark);
	}
	
	public final Subject getSubject() {
		return subject;
	}
	public final void setSubject(Subject subject) {
		this.subject = subject;
	}
	public final Student getStudent() {
		return student;
	}
	public final void setStudent(Student student) {
		this.student = student;
	}
	public final Date getDate() {
		return date;
	}
	public final void setDate(Date date) {
		this.date = date;
	}
	public final Double getMark() {
		return mark;
	}
	public final void setMark(Double mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Test [subject=" + subject + ", student=" + student + ", date=" + date + ", mark=" + mark + "]";
	}
	
	
}
