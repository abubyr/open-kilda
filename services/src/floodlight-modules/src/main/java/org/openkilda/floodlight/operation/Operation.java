/*
 * Copyright 2017 Telstra Open Source
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openkilda.floodlight.operation;

import org.openkilda.floodlight.service.batch.OFPendingMessage;

import java.util.List;

public abstract class Operation implements Runnable {
    private final OperationContext context;

    public Operation(OperationContext context) {
        this.context = context;
    }

    public void ioComplete(List<OFPendingMessage> payload, boolean isError) {
        throw new IllegalArgumentException("Can't handle IO response, because don't send any IO requests");
    }

    protected void startSubOperation(Operation operation) {
        operation.run();
    }

    protected OperationContext getContext() {
        return context;
    }
}
