/*
 * Copyright 2001-2005 (C) MetaStuff, Ltd. All Rights Reserved.
 * This software is open source.
 * See the bottom of this file for the licence.
 */

package cz.tdp.xtree;

import org.junit.Test;

import cz.tdp.xtree.Element;
import cz.tdp.xtree.Node;

/**
 * Tests the setText method
 *
 * @author <a href="mailto:maartenc@users.sourceforge.net">Maarten Coene </a>
 */
public class SetTextTest extends AbstractTestCase
{
  /*
   * The structure of the test document is: [root] [author name="James"
   * location="UK"] James Strachem
   * [url]http://sourceforge.net/users/jstrachan/[/url] [/author] [author
   * name="Bob" location="Canada"] Bob McWhirter
   * [url]http://sourceforge.net/users/werken/[/url] [/author] [/root]
   */

  @Test
  public void testSetText1() throws Exception {
    String newURL = "newURL";

    Node urlNode = document.selectSingleNode("//root/author[1]/url");
    urlNode.setText(newURL);

    assertEquals(newURL, urlNode.getText());
    assertTrue(urlNode instanceof Element);

    Element urlElement = (Element)urlNode;
    assertEquals(0, urlElement.elements().size());
  }

  @Test
  public void testSetText2() throws Exception {
    String newName = "Strachem James";

    Node authorNode = document.selectSingleNode("//root/author[1]");
    authorNode.setText(newName);

    assertEquals(newName, authorNode.getText());
    assertTrue(authorNode instanceof Element);

    Element urlElement = (Element)authorNode;
    assertEquals(1, urlElement.elements().size());
  }
}

/*
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided that the
 * following conditions are met:
 * 1. Redistributions of source code must retain copyright statements and
 * notices. Redistributions must also contain a copy of this document.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 3. The name "DOM4J" must not be used to endorse or promote products derived
 * from this Software without prior written permission of MetaStuff, Ltd. For
 * written permission, please contact dom4j-info@metastuff.com.
 * 4. Products derived from this Software may not be called "DOM4J" nor may
 * "DOM4J" appear in their names without prior written permission of MetaStuff,
 * Ltd. DOM4J is a registered trademark of MetaStuff, Ltd.
 * 5. Due credit should be given to the DOM4J Project - http://dom4j.sourceforge.net
 * THIS SOFTWARE IS PROVIDED BY METASTUFF, LTD. AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL METASTUFF, LTD. OR ITS CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * Copyright 2001-2005 (C) MetaStuff, Ltd. All Rights Reserved.
 */