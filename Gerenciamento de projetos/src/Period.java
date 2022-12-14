import java.util.Date;
import java.text.SimpleDateFormat;

public class Period {
	Date begin;
	Date end;
	
	Period(Date begin, Date end){
		this.begin = begin;
		this.end = end;
	}
	
	public String toString_begin(Period period){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(period.begin);
	}

	public String toString_end(Period period){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(period.end);
	}
}
