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

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

public abstract class AbstractDemoBean implements Serializable
{
  //@Inject -> would allow more "postconstructs", but using @PostConstruct is more obvious...
  @PostConstruct
  protected void init()
  {
    setCreationTime(Calendar.getInstance().getTime());
  }

  public void setCreationTime(Date creationTime)
  {
    this.creationTime = creationTime;
  }
  public Date getCreationTime()
  {
    return creationTime;
  }

  private Date creationTime;
  private static final long serialVersionUID = 1L;
}