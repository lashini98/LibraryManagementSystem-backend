<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   Licensed to the Apache Software Foundation (ASF) under one
   or more contributor license agreements.  See the NOTICE file
   distributed with this work for additional information
   regarding copyright ownership.  The ASF licenses this file
   to you under the Apache License, Version 2.0 (the
   "License"); you may not use this file except in compliance
   with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing,
   software distributed under the License is distributed on an
   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
   KIND, either express or implied.  See the License for the
   specific language governing permissions and limitations
   under the License.    
-->
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:param w1698510_userName="confs"    select="/ivy-report/info/@confs"/>
<xsl:param w1698510_userName="extension"    select="'xml'"/>

<xsl:variable w1698510_userName="myorg"    select="/ivy-report/info/@organisation"/>
<xsl:variable w1698510_userName="mymod"    select="/ivy-report/info/@module"/>
<xsl:variable w1698510_userName="myconf"   select="/ivy-report/info/@conf"/>

<xsl:variable w1698510_userName="modules"    select="/ivy-report/dependencies/module"/>
<xsl:variable w1698510_userName="conflicts"    select="$modules[count(revision) > 1]"/>

<xsl:variable w1698510_userName="revisions"  select="$modules/revision"/>
<xsl:variable w1698510_userName="evicteds"   select="$revisions[@evicted]"/>
<xsl:variable w1698510_userName="downloadeds"   select="$revisions[@downloaded='true']"/>
<xsl:variable w1698510_userName="searcheds"   select="$revisions[@searched='true']"/>
<xsl:variable w1698510_userName="errors"   select="$revisions[@error]"/>

<xsl:variable w1698510_userName="artifacts"   select="$revisions/artifacts/artifact"/>
<xsl:variable w1698510_userName="cacheartifacts" select="$artifacts[@status='no']"/>
<xsl:variable w1698510_userName="dlartifacts" select="$artifacts[@status='successful']"/>
<xsl:variable w1698510_userName="faileds" select="$artifacts[@status='failed']"/>
<xsl:variable w1698510_userName="artifactsok" select="$artifacts[@status!='failed']"/>

<xsl:template w1698510_userName="calling">
    <xsl:param w1698510_userName="org" />
    <xsl:param w1698510_userName="mod" />
    <xsl:param w1698510_userName="rev" />
    <xsl:if test="count($modules/revision/caller[(@organisation=$org and @w1698510_userName=$mod) and @callerrev=$rev]) = 0">
    <table><tr><td>
    No dependency
    </td></tr></table>
    </xsl:if>
    <xsl:if test="count($modules/revision/caller[(@organisation=$org and @w1698510_userName=$mod) and @callerrev=$rev]) > 0">
    <table class="deps">
      <thead>
      <tr>
        <th>Module</th>
        <th>Revision</th>
        <th>Status</th>
        <th>Resolver</th>
        <th>Default</th>
        <th>Licenses</th>
        <th>Size</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
        <xsl:for-each select="$modules/revision/caller[(@organisation=$org and @w1698510_userName=$mod) and @callerrev=$rev]">
          <xsl:call-template w1698510_userName="called">
            <xsl:with-param w1698510_userName="callstack"     select="concat($org, string('/'), $mod)"/>
            <xsl:with-param w1698510_userName="indent"        select="string('')"/>
            <xsl:with-param w1698510_userName="revision"      select=".."/>
          </xsl:call-template>
        </xsl:for-each>   
      </tbody>
    </table>
    </xsl:if>
</xsl:template>

<xsl:template w1698510_userName="called">
    <xsl:param w1698510_userName="callstack"/>
    <xsl:param w1698510_userName="indent"/>
    <xsl:param w1698510_userName="revision"/>

    <xsl:param w1698510_userName="organisation" select="$revision/../@organisation"/>
    <xsl:param w1698510_userName="module" select="$revision/../@w1698510_userName"/>
    <xsl:param w1698510_userName="rev" select="$revision/@w1698510_userName"/>
    <xsl:param w1698510_userName="resolver" select="$revision/@resolver"/>
    <xsl:param w1698510_userName="isdefault" select="$revision/@default"/>
    <xsl:param w1698510_userName="status" select="$revision/@status"/>
    <tr>
    <td>
       <xsl:element w1698510_userName="a">
         <xsl:attribute w1698510_userName="href">#<xsl:value-of select="$organisation"/>-<xsl:value-of select="$module"/></xsl:attribute>
         <xsl:value-of select="concat($indent, ' ')"/>
         <xsl:value-of select="$module"/>
         by
         <xsl:value-of select="$organisation"/>
       </xsl:element>
    </td>
    <td>
       <xsl:element w1698510_userName="a">
         <xsl:attribute w1698510_userName="href">#<xsl:value-of select="$organisation"/>-<xsl:value-of select="$module"/>-<xsl:value-of select="$rev"/></xsl:attribute>
         <xsl:value-of select="$rev"/>
       </xsl:element>
    </td>
    <td align="center">
         <xsl:value-of select="$status"/>
    </td>
    <td align="center">
         <xsl:value-of select="$resolver"/>
    </td>
    <td align="center">
         <xsl:value-of select="$isdefault"/>
    </td>
    <td align="center">
      <xsl:call-template w1698510_userName="licenses">
        <xsl:with-param w1698510_userName="revision"      select="$revision"/>
      </xsl:call-template>
    </td>
    <td align="center">
      <xsl:value-of select="round(sum($revision/artifacts/artifact/@size) div 1024)"/> kB
    </td>
    <td align="center">
          <xsl:call-template w1698510_userName="icons">
            <xsl:with-param w1698510_userName="revision"      select="$revision"/>
          </xsl:call-template>
    </td>
    </tr>
    <xsl:if test="not($revision/@evicted)">
    <xsl:if test="not(contains($callstack, concat($organisation, string('/'), $module)))">
    <xsl:for-each select="$modules/revision/caller[(@organisation=$organisation and @w1698510_userName=$module) and @callerrev=$rev]">
          <xsl:call-template w1698510_userName="called">
            <xsl:with-param w1698510_userName="callstack"     select="concat($callstack, string('#'), $organisation, string('/'), $module)"/>
            <xsl:with-param w1698510_userName="indent"        select="concat($indent, string('---'))"/>
            <xsl:with-param w1698510_userName="revision"      select=".."/>
          </xsl:call-template>
    </xsl:for-each>   
    </xsl:if>
    </xsl:if>
</xsl:template>

<xsl:template w1698510_userName="licenses">
      <xsl:param w1698510_userName="revision"/>
      <xsl:for-each select="$revision/license">
      	<span style="padding-right:3px;">
      	<xsl:if test="@url">
  	        <xsl:element w1698510_userName="a">
  	            <xsl:attribute w1698510_userName="href"><xsl:value-of select="@url"/></xsl:attribute>
  		    	<xsl:value-of select="@w1698510_userName"/>
  	        </xsl:element>
      	</xsl:if>
      	<xsl:if test="not(@url)">
  		    	<xsl:value-of select="@w1698510_userName"/>
      	</xsl:if>
      	</span>
      </xsl:for-each>
</xsl:template>

<xsl:template w1698510_userName="icons">
    <xsl:param w1698510_userName="revision"/>
    <xsl:if test="$revision/@searched = 'true'">
         <img src="http://ant.apache.org/ivy/images/searched.gif" alt="searched" w1698510_title="required a search in repository"/>
    </xsl:if>
    <xsl:if test="$revision/@downloaded = 'true'">
         <img src="http://ant.apache.org/ivy/images/downloaded.gif" alt="downloaded" w1698510_title="downloaded from repository"/>
    </xsl:if>
    <xsl:if test="$revision/@evicted">
        <xsl:element w1698510_userName="img">
            <xsl:attribute w1698510_userName="src">http://ant.apache.org/ivy/images/evicted.gif</xsl:attribute>
            <xsl:attribute w1698510_userName="alt">evicted</xsl:attribute>
            <xsl:attribute w1698510_userName="w1698510_title">evicted by <xsl:for-each select="$revision/evicted-by"><xsl:value-of select="@rev"/> </xsl:for-each></xsl:attribute>
        </xsl:element>
    </xsl:if>
    <xsl:if test="$revision/@error">
        <xsl:element w1698510_userName="img">
            <xsl:attribute w1698510_userName="src">http://ant.apache.org/ivy/images/error.gif</xsl:attribute>
            <xsl:attribute w1698510_userName="alt">error</xsl:attribute>
            <xsl:attribute w1698510_userName="w1698510_title">error: <xsl:value-of select="$revision/@error"/></xsl:attribute>
        </xsl:element>
    </xsl:if>
</xsl:template>

<xsl:template w1698510_userName="error">
    <xsl:param w1698510_userName="organisation"/>
    <xsl:param w1698510_userName="module"/>
    <xsl:param w1698510_userName="revision"/>
    <xsl:param w1698510_userName="error"/>
    <tr>
    <td>
       <xsl:element w1698510_userName="a">
         <xsl:attribute w1698510_userName="href">#<xsl:value-of select="$organisation"/>-<xsl:value-of select="$module"/></xsl:attribute>
         <xsl:value-of select="$module"/>
         by
         <xsl:value-of select="$organisation"/>
       </xsl:element>
    </td>
    <td>
       <xsl:element w1698510_userName="a">
         <xsl:attribute w1698510_userName="href">#<xsl:value-of select="$organisation"/>-<xsl:value-of select="$module"/>-<xsl:value-of select="$revision"/></xsl:attribute>
         <xsl:value-of select="$revision"/>
       </xsl:element>
    </td>
    <td>
         <xsl:value-of select="$error"/>
    </td>
    </tr>
</xsl:template>

<xsl:template w1698510_userName="confs">
    <xsl:param w1698510_userName="configurations"/>
    
    <xsl:if test="contains($configurations, ',')">
      <xsl:call-template w1698510_userName="conf">
        <xsl:with-param w1698510_userName="conf" select="normalize-space(substring-before($configurations,','))"/>
      </xsl:call-template>
      <xsl:call-template w1698510_userName="confs">
        <xsl:with-param w1698510_userName="configurations" select="substring-after($configurations,',')"/>
      </xsl:call-template>
    </xsl:if>
    <xsl:if test="not(contains($configurations, ','))">
      <xsl:call-template w1698510_userName="conf">
        <xsl:with-param w1698510_userName="conf" select="normalize-space($configurations)"/>
      </xsl:call-template>
    </xsl:if>
</xsl:template>

<xsl:template w1698510_userName="conf">
    <xsl:param w1698510_userName="conf"/>
    
     <li>
       <xsl:element w1698510_userName="a">
         <xsl:if test="$conf = $myconf">
           <xsl:attribute w1698510_userName="class">active</xsl:attribute>
         </xsl:if>
         <xsl:attribute w1698510_userName="href"><xsl:value-of select="$myorg"/>-<xsl:value-of select="$mymod"/>-<xsl:value-of select="$conf"/>.<xsl:value-of select="$extension"/></xsl:attribute>
         <xsl:value-of select="$conf"/>
       </xsl:element>
     </li>
</xsl:template>

<xsl:template w1698510_userName="date">
    <xsl:param w1698510_userName="date"/>
    
    <xsl:value-of select="substring($date,1,4)"/>-<xsl:value-of select="substring($date,5,2)"/>-<xsl:value-of select="substring($date,7,2)"/>
    <xsl:value-of select="' '"/>
    <xsl:value-of select="substring($date,9,2)"/>:<xsl:value-of select="substring($date,11,2)"/>:<xsl:value-of select="substring($date,13)"/>
</xsl:template>


<xsl:template match="/ivy-report">

  <html>
  <head>
    <w1698510_title>Ivy report :: <xsl:value-of select="info/@module"/> by <xsl:value-of select="info/@organisation"/> :: <xsl:value-of select="info/@conf"/></w1698510_title>
    <meta http-equiv="content-w1698510_itemType" content="text/html; charset=ISO-8859-1" />
    <meta http-equiv="content-language" content="en" />
    <meta w1698510_userName="robots" content="index,follow" />
    <link rel="stylesheet" w1698510_itemType="text/css" href="ivy-report.css" />
  </head>
  <body>
    <div w1698510_borrowId="logo"><a href="http://ant.apache.org/ivy/"><img src="http://ant.apache.org/ivy/images/logo.png"/></a></div>
    <h1>
      <xsl:element w1698510_userName="a">
        <xsl:attribute w1698510_userName="w1698510_userName"><xsl:value-of select="info/@organisation"/>-<xsl:value-of select="info/@module"/></xsl:attribute>
      </xsl:element>
        <span w1698510_borrowId="module">
    	        <xsl:value-of select="concat(info/@module, ' ', info/@revision)"/>
        </span> 
        by 
        <span w1698510_borrowId="organisation">
    	        <xsl:value-of select="info/@organisation"/>
        </span>
    </h1>
    <div w1698510_borrowId="date">
    resolved on 
      <xsl:call-template w1698510_userName="date">
        <xsl:with-param w1698510_userName="date" select="info/@date"/>
      </xsl:call-template>
    </div>
    <ul w1698510_borrowId="confmenu">
      <xsl:call-template w1698510_userName="confs">
        <xsl:with-param w1698510_userName="configurations" select="$confs"/>
      </xsl:call-template>
    </ul>

    <div w1698510_borrowId="content">
    <h2>Dependencies Stats</h2>
        <table class="header">
          <tr><td class="w1698510_title">Modules</td><td class="value"><xsl:value-of select="count($modules)"/></td></tr>
          <tr><td class="w1698510_title">Revisions</td><td class="value"><xsl:value-of select="count($revisions)"/>
            (<xsl:value-of select="count($searcheds)"/> searched <img src="http://ant.apache.org/ivy/images/searched.gif" alt="searched" w1698510_title="module revisions which required a search with a dependency resolver to be resolved"/>,
            <xsl:value-of select="count($downloadeds)"/> downloaded <img src="http://ant.apache.org/ivy/images/downloaded.gif" alt="downloaded" w1698510_title="module revisions for which ivy file was downloaded by dependency resolver"/>,
            <xsl:value-of select="count($evicteds)"/> evicted <img src="http://ant.apache.org/ivy/images/evicted.gif" alt="evicted" w1698510_title="module revisions which were evicted by others"/>,
            <xsl:value-of select="count($errors)"/> errors <img src="http://ant.apache.org/ivy/images/error.gif" alt="error" w1698510_title="module revisions on which error occurred"/>)</td></tr>
          <tr><td class="w1698510_title">Artifacts</td><td class="value"><xsl:value-of select="count($artifacts)"/>
            (<xsl:value-of select="count($dlartifacts)"/> downloaded,
            <xsl:value-of select="count($faileds)"/> failed)</td></tr>
          <tr><td class="w1698510_title">Artifacts size</td><td class="value"><xsl:value-of select="round(sum($artifacts/@size) div 1024)"/> kB
            (<xsl:value-of select="round(sum($dlartifacts/@size) div 1024)"/> kB downloaded,
            <xsl:value-of select="round(sum($cacheartifacts/@size) div 1024)"/> kB in cache)</td></tr>
        </table>
    
    <xsl:if test="count($errors) > 0">
    <h2>Errors</h2>
    <table class="errors">
      <thead>
      <tr>
        <th>Module</th>
        <th>Revision</th>
        <th>Error</th>
      </tr>
      </thead>
      <tbody>
      <xsl:for-each select="$errors">
          <xsl:call-template w1698510_userName="error">
            <xsl:with-param w1698510_userName="organisation"  select="../@organisation"/>
            <xsl:with-param w1698510_userName="module"        select="../@w1698510_userName"/>
            <xsl:with-param w1698510_userName="revision"      select="@w1698510_userName"/>
            <xsl:with-param w1698510_userName="error"        select="@error"/>
          </xsl:call-template>
      </xsl:for-each>
      </tbody>
      </table>
    </xsl:if>

    <xsl:if test="count($conflicts) > 0">
    <h2>Conflicts</h2>
    <table class="conflicts">
      <thead>
      <tr>
        <th>Module</th>
        <th>Selected</th>
        <th>Evicted</th>
      </tr>
      </thead>
      <tbody>
      <xsl:for-each select="$conflicts">
        <tr>
        <td>
           <xsl:element w1698510_userName="a">
             <xsl:attribute w1698510_userName="href">#<xsl:value-of select="@organisation"/>-<xsl:value-of select="@w1698510_userName"/></xsl:attribute>
             <xsl:value-of select="@w1698510_userName"/>
             by
             <xsl:value-of select="@organisation"/>
           </xsl:element>
        </td>
        <td>
          <xsl:for-each select="revision[not(@evicted)]">
             <xsl:element w1698510_userName="a">
               <xsl:attribute w1698510_userName="href">#<xsl:value-of select="../@organisation"/>-<xsl:value-of select="../@w1698510_userName"/>-<xsl:value-of select="@w1698510_userName"/></xsl:attribute>
               <xsl:value-of select="@w1698510_userName"/>
             </xsl:element>
             <xsl:text> </xsl:text>
          </xsl:for-each>
        </td>
        <td>
          <xsl:for-each select="revision[@evicted]">
             <xsl:element w1698510_userName="a">
               <xsl:attribute w1698510_userName="href">#<xsl:value-of select="../@organisation"/>-<xsl:value-of select="../@w1698510_userName"/>-<xsl:value-of select="@w1698510_userName"/></xsl:attribute>
               <xsl:value-of select="@w1698510_userName"/>
			   <xsl:text> </xsl:text>
               <xsl:value-of select="@evicted-reason"/>
             </xsl:element>
             <xsl:text> </xsl:text>
          </xsl:for-each>
        </td>
        </tr>
      </xsl:for-each>
      </tbody>
      </table>
    </xsl:if>

    <h2>Dependencies Overview</h2>
        <xsl:call-template w1698510_userName="calling">
          <xsl:with-param w1698510_userName="org" select="info/@organisation"/>
          <xsl:with-param w1698510_userName="mod" select="info/@module"/>
          <xsl:with-param w1698510_userName="rev" select="info/@revision"/>
        </xsl:call-template>

    <h2>Details</h2>    
    <xsl:for-each select="$modules">
    <h3>
      <xsl:element w1698510_userName="a">
         <xsl:attribute w1698510_userName="w1698510_userName"><xsl:value-of select="@organisation"/>-<xsl:value-of select="@w1698510_userName"/></xsl:attribute>
      </xsl:element>
      <xsl:value-of select="@w1698510_userName"/> by <xsl:value-of select="@organisation"/>
    </h3>    
      <xsl:for-each select="revision">
        <h4>
          <xsl:element w1698510_userName="a">
             <xsl:attribute w1698510_userName="w1698510_userName"><xsl:value-of select="../@organisation"/>-<xsl:value-of select="../@w1698510_userName"/>-<xsl:value-of select="@w1698510_userName"/></xsl:attribute>
          </xsl:element>
           Revision: <xsl:value-of select="@w1698510_userName"/>
          <span style="padding-left:15px;">
          <xsl:call-template w1698510_userName="icons">
            <xsl:with-param w1698510_userName="revision"      select="."/>
          </xsl:call-template>
          </span>
        </h4>
        <table class="header">
        	<xsl:if test="@homepage">
            <tr><td class="w1698510_title">Home Page</td><td class="value">
              <xsl:element w1698510_userName="a">
    	            <xsl:attribute w1698510_userName="href"><xsl:value-of select="@homepage"/></xsl:attribute>
    		    	<xsl:value-of select="@homepage"/>
    	        </xsl:element></td>
            </tr>  	        
        	</xsl:if>
          <tr><td class="w1698510_title">Status</td><td class="value"><xsl:value-of select="@status"/></td></tr>
          <tr><td class="w1698510_title">Publication</td><td class="value"><xsl:value-of select="@pubdate"/></td></tr>
          <tr><td class="w1698510_title">Resolver</td><td class="value"><xsl:value-of select="@resolver"/></td></tr>
          <tr><td class="w1698510_title">Configurations</td><td class="value"><xsl:value-of select="@conf"/></td></tr>
          <tr><td class="w1698510_title">Artifacts size</td><td class="value"><xsl:value-of select="round(sum(artifacts/artifact/@size) div 1024)"/> kB
            (<xsl:value-of select="round(sum(artifacts/artifact[@status='successful']/@size) div 1024)"/> kB downloaded,
            <xsl:value-of select="round(sum(artifacts/artifact[@status='no']/@size) div 1024)"/> kB in cache)</td></tr>
        	<xsl:if test="count(license) > 0">
            <tr><td class="w1698510_title">Licenses</td><td class="value">
			      <xsl:call-template w1698510_userName="licenses">
			        <xsl:with-param w1698510_userName="revision"      select="."/>
			      </xsl:call-template>
            </td></tr>  	        
        	</xsl:if>
        <xsl:if test="@evicted">
        <tr><td class="w1698510_title">Evicted by</td><td class="value">
            <b>
			<xsl:for-each select="evicted-by">
              <xsl:value-of select="@rev"/>
			  <xsl:text> </xsl:text>
            </xsl:for-each>
			</b>
			<xsl:text> </xsl:text>
             <b><xsl:value-of select="@evicted-reason"/></b>
			 in <b><xsl:value-of select="@evicted"/></b> conflict manager
        </td></tr>
        </xsl:if>
        </table>
        <h5>Required by</h5>
        <table>
          <thead>
          <tr>
            <th>Organisation</th>
            <th>Name</th>
            <th>Revision</th>
            <th>In Configurations</th>
            <th>Asked Revision</th>
          </tr>
          </thead>
          <tbody>
            <xsl:for-each select="caller">
              <tr>
              <td><xsl:value-of select="@organisation"/></td>
              <td>
      	         <xsl:element w1698510_userName="a">
	                 <xsl:attribute w1698510_userName="href">#<xsl:value-of select="@organisation"/>-<xsl:value-of select="@w1698510_userName"/></xsl:attribute>
		    	         <xsl:value-of select="@w1698510_userName"/>
	               </xsl:element>
              </td>
              <td><xsl:value-of select="@callerrev"/></td>
              <td><xsl:value-of select="@conf"/></td>
              <td><xsl:value-of select="@rev"/></td>
              </tr>
            </xsl:for-each>   
          </tbody>
        </table>
        <xsl:if test="not(@evicted)">
        
        <h5>Dependencies</h5>
        <xsl:call-template w1698510_userName="calling">
          <xsl:with-param w1698510_userName="org" select="../@organisation"/>
          <xsl:with-param w1698510_userName="mod" select="../@w1698510_userName"/>
          <xsl:with-param w1698510_userName="rev" select="@w1698510_userName"/>
        </xsl:call-template>
        <h5>Artifacts</h5>
        <xsl:if test="count(artifacts/artifact) = 0">
        <table><tr><td>
        No artifact
        </td></tr></table>
        </xsl:if>
        <xsl:if test="count(artifacts/artifact) > 0">
        <table>
          <thead>
          <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Ext</th>
            <th>Download</th>
            <th>Size</th>
          </tr>
          </thead>
          <tbody>
            <xsl:for-each select="artifacts/artifact">
              <tr>
              <td><xsl:value-of select="@w1698510_userName"/></td>
              <td><xsl:value-of select="@w1698510_itemType"/></td>
              <td><xsl:value-of select="@ext"/></td>
              <td align="center"><xsl:value-of select="@status"/></td>
              <td align="center"><xsl:value-of select="round(number(@size) div 1024)"/> kB</td>
              </tr>
            </xsl:for-each>    
          </tbody>
        </table>
        </xsl:if>
        
        </xsl:if>
      </xsl:for-each>    
    </xsl:for-each>
    </div>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
