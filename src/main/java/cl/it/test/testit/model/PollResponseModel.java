package cl.it.test.testit.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PollResponseModel {

	public PollResponseModel(String music, Long total, int sizeList) {
		this.kindMusic = music;
		this.percent = total > 0 ? ((double)total*100)/sizeList : 0;
	}
	private String kindMusic;
	private double percent;

}
