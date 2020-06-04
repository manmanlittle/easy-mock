package cn.shaikuba.mock.service;

import cn.shaikuba.mock.common.process.entity.MockRequest;
import cn.shaikuba.mock.data.entity.base.BaseEntity;
import cn.shaikuba.mock.data.entity.base.Criteria;

import java.util.List;

public interface MockRequestService<T extends BaseEntity & MockRequest> {

    T saveMockRequest(T mockRequest);

    void deleteMockRequest(List<Long> idList);

    void updateMockRequest(T mockRequest);

    T findMockRequest(Long mockRequestId);

    List<T> findMockRequests(Criteria<String, Object> criteria);
}
