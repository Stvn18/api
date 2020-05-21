package gt.masterdevel.api.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class MessageBodyDto {
    List<String> tags;
}
