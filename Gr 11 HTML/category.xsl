<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
	<head> 
		<link rel="stylesheet" type="text/css" 	href="style.css" />
	</head> 
	
	<body id="backgroundS">
		<h2> Items sorted by category: </h2>
		<table boarder="1" frame="box" rules="none">		
	
		<xsl:for-each select="superFood/inventory">

			<!-- sort according to category -->
			<xsl:sort select="Category"/>
			
			<xsl:choose>
			 
				<!-- is on sale -->
				<xsl:when test="ID[@sales='yes']">
					<td id="explanation">Item on Sale:</td>
				  		
					<tr>	
						<td id="company"><xsl:value-of select="Company"/></td>
						<td id="product"><xsl:value-of select="Product"/></td>
						<td> </td>	
						<td rowspan="3"><img src="{Picture}" width="90" height="60" alt="Picture" ALIGN="Right" border="1"></img></td>
					</tr>
				
					<tr>
						<td> </td>
						<td id="bbefore">Was <font id="before"><xsl:value-of select="Price"/></font></td>
						<td id="sale"><xsl:value-of select="Sale"/></td>
					</tr>
				
					<tr>
						<td id="description"><xsl:value-of select="Description"/></td>
						<td> </td>
						<td id="unit"><xsl:value-of select="Unit"/></td>
					</tr>
				
					<tr>
						<td colspan="4"> <hr/> </td>
					</tr>
				
					<tr>
						<td colspan="4"> <hr/> </td>
					</tr>
				</xsl:when>

				<!-- not on sale -->
				<xsl:otherwise>
					<td id="explanation">Item Not on Sale</td>
			  	
					<tr>	
						<td id="company"><xsl:value-of select="Company"/></td>
						<td id="product"><xsl:value-of select="Product"/></td>
						<td> </td>	
						<td rowspan="3"><img src="{Picture}" width="90" height="60" alt="Picture" ALIGN="Right" border="1"></img></td>
					</tr>
				
					<tr>
						<td> </td>
						<td> </td>
						<td id="price"><xsl:value-of select="Price"/></td>
					</tr>
				
					<tr>
						<td id="description"><xsl:value-of select="Description"/></td>
						<td> </td>
						<td id="unit"><xsl:value-of select="Unit"/></td>
					</tr>
				
					<tr>
						<td colspan="4"> <hr/> </td>
					</tr>
				
					<tr>
						<td colspan="4"> <hr/> </td>
					</tr>

				</xsl:otherwise>

			</xsl:choose>

		</xsl:for-each>			   
		
		</table>

	</body>

</html>

</xsl:template>

</xsl:stylesheet> 
