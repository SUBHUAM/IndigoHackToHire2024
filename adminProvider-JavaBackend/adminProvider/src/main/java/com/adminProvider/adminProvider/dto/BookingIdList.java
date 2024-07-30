package com.adminProvider.adminProvider.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingIdList {

    private List<String> bookingIdList;
}
