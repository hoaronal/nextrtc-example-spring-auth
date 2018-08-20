package org.nextrtc.examples.videochat_auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.nextrtc.examples.videochat_auth.SessionWrapper;
import org.nextrtc.signalingserver.api.NextRTCEvents;
import org.nextrtc.signalingserver.api.NextRTCHandler;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NextRTCEventListener(NextRTCEvents.SESSION_OPENED)
public class OpenSessionHandler implements NextRTCHandler {
    @Override
    public void handleEvent(NextRTCEvent event) {
        event.from().ifPresent(m -> {
            log.info("Principal: " + ((SessionWrapper) m.getConnection()).getPrincipal());
            m.getConnection().sendObject("Welcome!!!!!!");
        });

    }
}
