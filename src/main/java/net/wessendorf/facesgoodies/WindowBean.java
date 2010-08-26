/*
 * Copyright (C) 2010 Matthias Weßendorf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.facesgoodies;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.Conversation;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowScoped;

@Named
@WindowScoped
public class WindowBean extends AbstractDemoBean
{
  @Inject private Conversation conversation;  
  //@Inject private WindowContext windowContext;

  public WindowBean()
  {
    super();
  }

  /**
   * invalidate the whole {@link org.apache.myfaces.extensions.cdi.core.api.scope.conversation.WindowContext}
   * <p
   */
  public String stopMe()
  {
    // this would not only release the windowCtx,
    // it also invalidates all CODI conversations immediately....
    //windowContext.end()
    
    conversation.end();
    return null;
  }


  private static final long serialVersionUID = 1L;
}