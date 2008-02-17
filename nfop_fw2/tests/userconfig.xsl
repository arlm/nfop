<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

	<xsl:template match="configuration">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="userconfig" page-height="29.7cm" page-width="25cm" margin-top="0.5cm" margin-bottom="0.5cm" margin-left="0.5cm" margin-right="0.5cm">
					<fo:region-body/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="userconfig">
				<fo:flow flow-name="xsl-region-body">
					<fo:block padding="2pt" text-align="center">
						<fo:table table-layout="fixed">
							<fo:table-column column-width="8cm"/>
							<fo:table-column column-width="8cm"/>
							<fo:table-column column-width="8cm"/>
							<fo:table-body>
								<xsl:for-each select="fonts/font">
									<xsl:call-template name="font-triplet-row">
										<xsl:with-param name="font-triplet" select="font-triplet"/>
									</xsl:call-template>
								</xsl:for-each>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template name="font-triplet-row">
		<xsl:param name="font-triplet"/>
		<fo:table-row>
			<xsl:call-template name="font-triplet-cell">
				<xsl:with-param name="font-triplet-attr" select="$font-triplet/@name"/>
				<xsl:with-param name="font-family"  select="$font-triplet/@name"/>
				<xsl:with-param name="font-style"   select="$font-triplet/@style"/>
				<xsl:with-param name="font-weight" select="$font-triplet/@weight"/>
			</xsl:call-template>
				<xsl:call-template name="font-triplet-cell">
				<xsl:with-param name="font-triplet-attr" select="$font-triplet/@style"/>
				<xsl:with-param name="font-family"  select="$font-triplet/@name"/>
				<xsl:with-param name="font-style"   select="$font-triplet/@style"/>
				<xsl:with-param name="font-weight" select="$font-triplet/@weight"/>
			</xsl:call-template>
			<xsl:call-template name="font-triplet-cell">
				<xsl:with-param name="font-triplet-attr" select="$font-triplet/@weight"/>
				<xsl:with-param name="font-family"  select="$font-triplet/@name"/>
				<xsl:with-param name="font-style"   select="$font-triplet/@style"/>
				<xsl:with-param name="font-weight" select="$font-triplet/@weight"/>
			</xsl:call-template>
		</fo:table-row>
	</xsl:template>

	<xsl:template name="font-triplet-cell">
	<xsl:param name="font-triplet-attr"/>
	<xsl:param name="font-family"/>
	<xsl:param name="font-style"/>
	<xsl:param name="font-weight"/>
		<fo:table-cell border-style="solid" border-width="0.5px">
            <xsl:call-template name="font-triplet-block">
                <xsl:with-param name="value" select="$font-triplet-attr"/>
                <xsl:with-param name="font-family" select="$font-family"/>
                <xsl:with-param name="font-style" select="$font-style"/>
                <xsl:with-param name="font-weight" select="$font-weight"/>
                <xsl:with-param name="font-size" select="20"/>
            </xsl:call-template>
		</fo:table-cell>
	</xsl:template>

	<xsl:template name="font-triplet-block">
	<xsl:param name="value"/>
	<xsl:param name="font-family"/>
	<xsl:param name="font-style"/>
	<xsl:param name="font-weight"/>
	<xsl:param name="font-size"/>
	    <xsl:text disable-output-escaping="yes">&lt;fo:block font-family="</xsl:text><xsl:value-of select="$font-family"/><xsl:text disable-output-escaping="yes">"</xsl:text>
		<xsl:text disable-output-escaping="yes"> font-size="</xsl:text><xsl:value-of select="$font-size"/><xsl:text disable-output-escaping="yes">pt"</xsl:text>
		<xsl:text disable-output-escaping="yes"> font-style="</xsl:text><xsl:value-of select="$font-style"/><xsl:text disable-output-escaping="yes">"</xsl:text>
	    <xsl:text disable-output-escaping="yes"> font-weight="</xsl:text><xsl:value-of select="$font-weight"/><xsl:text disable-output-escaping="yes">"</xsl:text>
	    <xsl:text disable-output-escaping="yes">&gt;</xsl:text>
		<xsl:value-of select="$value"/>
		<xsl:text disable-output-escaping="yes">&lt;/fo:block&gt;</xsl:text>
	</xsl:template>

</xsl:stylesheet>