/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1999-2002 Gerald Brose
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */
package org.jacorb.orb.policies;

import org.omg.CORBA.*;
import org.omg.Messaging.*;

public class RoutingPolicy extends _RoutingPolicyLocalBase
{
    private RoutingTypeRange routing_range;
    
    public RoutingPolicy (RoutingTypeRange routing_range)
    {
        this.routing_range = routing_range;
    }
    
    public RoutingPolicy (org.omg.CORBA.Any value)
    {
        this.routing_range = RoutingTypeRangeHelper.extract (value);
    }

    public RoutingTypeRange routing_range()
    {
        return routing_range;
    }

    public int policy_type()
    {
        return ROUTING_POLICY_TYPE.value;
    }

    public Policy copy()
    {
        RoutingTypeRange copy_range = 
                                new RoutingTypeRange (routing_range.min,
                                                      routing_range.max);
        return new RoutingPolicy (copy_range);
    }

    public void destroy()
    {
    }

}
