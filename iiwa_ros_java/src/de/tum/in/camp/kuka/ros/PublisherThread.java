/**
 * Copyright (C) 2016-2019 Salvatore Virga - salvo.virga@tum.de, Marco Esposito - marco.esposito@tum.de
 * Technische Universit�t M�nchen Chair for Computer Aided Medical Procedures and Augmented Reality Fakult�t
 * f�r Informatik / I16, Boltzmannstra�e 3, 85748 Garching bei M�nchen, Germany http://campar.in.tum.de All
 * rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the
 * following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package de.tum.in.camp.kuka.ros;

import java.util.TimerTask;

import com.kuka.roboticsAPI.geometricModel.ObjectFrame;

public class PublisherThread extends TimerTask {
  private iiwaPublisher publisher = null;
  private ObjectFrame endpointFrame = null;

  public PublisherThread(iiwaPublisher publisher, ObjectFrame endpointFrame) {
    this.publisher = publisher;
    this.endpointFrame = endpointFrame;
  }

  public void changeEndpointFrame(ObjectFrame endpointFrame) {
    this.endpointFrame = endpointFrame;
  }

  public void run() {
    try {
      publisher.publishCurrentState(endpointFrame);
    }
    catch (InterruptedException e) {
      Logger.error(e.toString());
    }
  }
}
