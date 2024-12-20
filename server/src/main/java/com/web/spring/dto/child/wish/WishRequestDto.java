package com.web.spring.dto.child.wish;

import com.web.spring.entity.IsFinish;
import com.web.spring.entity.Wish;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishRequestDto {	
	
	@NotNull
	private Long childNum;
	
	@NotNull
	private String img;
	
	@NotNull
	private String name;

	@NotNull
	private int price;
	
	@NotNull
	private int savingAmt;
	
	@NotNull
	private IsFinish isFinish;
	
	public Wish toWish(WishRequestDto wishRequestDto, String imgUrl) {
		
		return Wish.builder()
					.img(imgUrl)
					.name(wishRequestDto.getName())
					.price(wishRequestDto.getPrice())
	                .isFinish(IsFinish.INCOMPLETE)
					.build();
	}

//	@Override
//	public String toString() {
//		return "WishRequestDto [childNum=" + childNum + ", img=" + img + ", name=" + name + ", price=" + price + "]";
//	}
	
}