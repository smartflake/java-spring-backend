package com.services.app.infra.model.request;

import com.services.app.infra.entity.Category;
import com.services.app.infra.model.GenericRequest;
import lombok.*;

import java.util.Set;

/**
 * @author Ashwani Pandey
 * @created 25/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddCategoryRequest extends BaseRequest implements GenericRequest {

    private String companyId;

    private Set<Category> categories;

}
