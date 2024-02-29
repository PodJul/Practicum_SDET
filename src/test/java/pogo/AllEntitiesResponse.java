package pogo;

import java.util.List;

public class AllEntitiesResponse {

    private List<EntityResponse> entity;
    int page;
    int perPage;

    public AllEntitiesResponse(List<EntityResponse> entity, int page, int perPage) {
        this.entity = entity;
        this.page = page;
        this.perPage = perPage;
    }

    public AllEntitiesResponse() {
    }

    public List<EntityResponse> getEntity() {
        return entity;
    }

    public void setEntity(List<EntityResponse> entity) {
        this.entity = entity;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}
