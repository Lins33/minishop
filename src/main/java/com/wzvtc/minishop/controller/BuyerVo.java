package com.wzvtc.minishop.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BuyerVo implements Serializable {
    Integer id;
    String session_id;
    String username;
}
