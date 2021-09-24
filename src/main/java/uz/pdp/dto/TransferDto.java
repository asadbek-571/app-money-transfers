package uz.pdp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferDto {

    private Long fromCard;
    private Long toCard;
    private Double amount;

}
