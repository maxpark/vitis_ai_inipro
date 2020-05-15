DESCRIPTION = "The glog library implements application-level logging. This \
library provides logging APIs based on C++-style streams and various helper \
macros."
HOMEPAGE = "https://github.com/google/glog"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=dc9db360e0bbd4e46672f3fd91dd6c4b"

DEPENDS = "libunwind"

SRC_URI = " \
    git://github.com/google/glog.git \
	file://0001-Modify-interface-link-libraries.patch \
"

SRCREV = "96a2f23dca4cc7180821ca5f32e526314395d26a"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "shared"
PACKAGECONFIG[shared] = "-DBUILD_SHARED_LIBS=on,-DBUILD_SHARED_LIBS=off"

RDEPENDS_${PN} += "libunwind"

inherit cmake
