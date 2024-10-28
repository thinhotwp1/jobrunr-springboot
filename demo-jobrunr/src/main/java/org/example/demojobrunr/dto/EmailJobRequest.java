package org.example.demojobrunr.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmailJobRequest extends JobRequestAbstract{
    private List<String> emailList;
}
